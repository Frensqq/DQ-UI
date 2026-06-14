package com.example.dq_ui.Inputs

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposableTarget
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dq_ui.Button.ButtonSmall
import com.example.dq_ui.R
import com.example.dq_ui.UI.DiceQuestGradients
import com.example.dq_ui.UI.DiceQuestGradients.PurpleGlow
import com.example.dq_ui.UI.DiceQuestTheme


@Composable
fun InputText(text: String, placeholder: String,  onValueChange:(String) -> Unit, isPass: Boolean, isError: Boolean = false){

    var passView by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = text,
        onValueChange ={onValueChange(it)},
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = DiceQuestTheme.colors.TextPrimary,
            unfocusedTextColor = DiceQuestTheme.colors.TextPrimary,
            focusedContainerColor = DiceQuestTheme.colors.SurfaceVariant.copy(alpha = 0.2f),
            unfocusedContainerColor = DiceQuestTheme.colors.SurfaceVariant.copy(alpha = 0.2f),
            unfocusedBorderColor = Color.Transparent,
            focusedBorderColor =  Color.Transparent,
            cursorColor = DiceQuestTheme.colors.PrimaryLight,
            errorContainerColor = DiceQuestTheme.colors.SurfaceVariant.copy(alpha = 0.2f),
            errorBorderColor = DiceQuestTheme.colors.Error.copy(alpha = 0.5f),
            errorCursorColor = DiceQuestTheme.colors.Error.copy(alpha = 0.5f),
            errorTextColor = DiceQuestTheme.colors.Error.copy(alpha = 0.5f),
        ),
        trailingIcon = {
            if (isPass) {
                Icon(
                    painter = painterResource(if (!passView) R.drawable.eye_crossed else R.drawable.eye),
                    contentDescription = null, tint = DiceQuestTheme.colors.TextPrimary.copy(alpha = 0.7f),
                    modifier = Modifier.clickable { passView = !passView }
                )
            }
        },
        visualTransformation = if (passView && isPass) {
            PasswordVisualTransformation()
        } else VisualTransformation.None,
        isError = isError,
        placeholder = { Text(text = placeholder,
            color = DiceQuestTheme.colors.TextSecondary,
            style = DiceQuestTheme.typography.titleMedium)},
        modifier = Modifier.fillMaxWidth().height(50.dp),
        shape = RoundedCornerShape(10.dp),
        textStyle = DiceQuestTheme.typography.titleMedium,
    )

}

@Preview
@Composable
fun InputTextPrewiew(){
    Column(modifier = Modifier.fillMaxSize()
        .background(PurpleGlow).padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)

    ) {

        Spacer(modifier = Modifier.size(50.dp))

        InputText("", "Test", {}, false)
        InputText("test", "", {}, false)
        InputText("test", "", {}, false, true)

        InputText("", "test", {}, true)
        InputText("test", "", {}, true)



    }
}