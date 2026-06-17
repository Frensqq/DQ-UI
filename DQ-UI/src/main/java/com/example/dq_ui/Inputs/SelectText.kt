package com.example.dq_ui.Inputs

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dq_ui.R
import com.example.dq_ui.UI.DiceQuestTheme
import com.example.dq_ui.UI.SpacerH

@Composable
fun TextSelect(textTitle: String?,
               value: String,
               listValue: List<String>,
               onChangeValue:(String) ->Unit,
               placeholder: String
){
    var state by remember { mutableStateOf(false) }


    Column(modifier = Modifier.fillMaxWidth()) {
        OutlinedTextField(
            value = value,
            onValueChange = {},
            modifier = Modifier.fillMaxWidth().height(54.dp),
            shape = androidx.compose.foundation.shape.RoundedCornerShape(10.dp),
            trailingIcon = {
                Icon(
                    painter = if (state) painterResource(R.drawable.arrow_up) else painterResource(R.drawable.arrow_down),
                    contentDescription = null, tint = DiceQuestTheme.colors.Primary,
                    modifier = Modifier
                        .clickable { state = !state }

                )
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = DiceQuestTheme.colors.TextPrimary,
                unfocusedTextColor = DiceQuestTheme.colors.TextPrimary,
                focusedContainerColor = DiceQuestTheme.colors.SurfaceVariant.copy(alpha = 0.2f),
                unfocusedContainerColor = DiceQuestTheme.colors.SurfaceVariant.copy(alpha = 0.2f),
                disabledContainerColor = DiceQuestTheme.colors.SurfaceVariant.copy(alpha = 0.2f),
                unfocusedBorderColor = Color.Transparent,
                focusedBorderColor =  Color.Transparent,
                cursorColor = DiceQuestTheme.colors.PrimaryLight,
                errorContainerColor = DiceQuestTheme.colors.SurfaceVariant.copy(alpha = 0.2f),
                errorBorderColor = DiceQuestTheme.colors.Error.copy(alpha = 0.5f),
                errorCursorColor = DiceQuestTheme.colors.Error.copy(alpha = 0.5f),
                errorTextColor = DiceQuestTheme.colors.Error.copy(alpha = 0.5f),
            ),
            placeholder = {
                Text(
                    placeholder,
                    style = DiceQuestTheme.typography.bodyLarge,
                    color = DiceQuestTheme.colors.TextPrimary,
                    modifier = Modifier.padding(horizontal = 10.dp)
                )
            },
            textStyle = DiceQuestTheme.typography.bodyLarge,
            readOnly = true
        )

        DropdownMenu(
            state,
            onDismissRequest = { state = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            listValue.forEach { item ->
                DropdownMenuItem(
                    text = { Text(item) },
                    onClick = {
                        onChangeValue(item)
                        state = false
                    }
                )
            }

        }
    }

}
@Preview
@Composable
fun PreviewSelect(){
    var value by remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        TextSelect(
            "Пол", value, listOf("Мужской", "Женский", "Другое"),
            { Curr ->
                value = Curr
            }, "Пол"
        )
    }
}