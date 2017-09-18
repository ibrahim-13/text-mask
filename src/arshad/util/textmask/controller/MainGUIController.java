//    Copyright (C) 2017 MD. Ibrahim Khan
//
//    Project Name: 
//    Author: MD. Ibrahim Khan
//    Author's Email: ib.arshad777@gmail.com
//
//    Redistribution and use in source and binary forms, with or without modification,
//    are permitted provided that the following conditions are met:
//
//    1. Redistributions of source code must retain the above copyright notice, this
//       list of conditions and the following disclaimer.
//
//    2. Redistributions in binary form must reproduce the above copyright notice, this
//       list of conditions and the following disclaimer in the documentation and/or
//       other materials provided with the distribution.
//
//    3. Neither the name of the copyright holder nor the names of the contributors may
//       be used to endorse or promote products derived from this software without
//       specific prior written permission.
//
//    THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
//    ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
//    WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
//    IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
//    INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING
//    BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
//    DATA, OR PROFITS; OR BUSINESS INTERRUPTIONS) HOWEVER CAUSED AND ON ANY THEORY OF
//    LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE
//    OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
//    OF THE POSSIBILITY OF SUCH DAMAGE.

package arshad.util.textmask.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author Arshad
 */
public class MainGUIController implements Initializable {
    
    @FXML
    private TextField TF_InputString;
    @FXML
    private TextArea TA_Output;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        byte[] aa = { 0x41, 0x72, 0x73, 0x68, 0x61, 0x64 };
        System.out.println(new String(aa));
        assert TF_InputString != null : "fx:id=\"TF_InputString\" was not injected: check your FXML file 'MainGUI.fxml'.";
        assert TA_Output != null : "fx:id=\"TA_Output\" was not injected: check your FXML file 'MainGUI.fxml'.";
    }    

    @FXML
    private void btn_ApplyMask(ActionEvent event) {
        TA_Output.setText("");
        byte[] inputText = TF_InputString.getText().getBytes();
        if(inputText.length < 1) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("{ 0x").append(Integer.toHexString(inputText[0]));
        for(int i = 1; i < inputText.length; i++) {
            sb.append(", ");
            if(i % 7 == 0) {
                sb.append("\n");
            }
            sb.append("0x").append(Integer.toHexString(inputText[i]));
        }
        sb.append(" }");
        TA_Output.setText(sb.toString());
    }
    
}
