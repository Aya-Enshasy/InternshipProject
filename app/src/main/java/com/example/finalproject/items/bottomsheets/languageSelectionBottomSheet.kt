package com.example.finalproject.items.bottomsheets


 import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
 import androidx.compose.ui.res.stringResource
 import androidx.compose.ui.unit.dp
 import com.example.finalproject.R

@Composable
fun LanguageSelectionContent(selected: String, onSelect: (String) -> Unit) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)) {

        Text(
            text = stringResource(R.string.language_preference),
            style = MaterialTheme.typography.titleMedium,
            color = Color(0xFF027B89)
        )

        Spacer(modifier = Modifier.height(16.dp))

        LanguageOption(
            language = stringResource(R.string.arabic),
            flagRes = R.drawable.arabic,
            selected = selected == "ar",
            onClick = { onSelect("ar") }
        )

        LanguageOption(
            language = stringResource(R.string.english),
            flagRes = R.drawable.english,
            selected = selected == "en",
            onClick = { onSelect("en") }
        )
    }
}


@Composable
fun LanguageOption(
    language: String,
    flagRes: Int,
    selected: Boolean,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = flagRes),
            contentDescription = "Flag",
            modifier = Modifier.size(24.dp)
        )

        Spacer(modifier = Modifier.width(12.dp))

        Text(
            text = language,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.weight(1f)
        )

        if (selected) {
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = "Selected",
                tint = Color(0xFF027B89) // لون علامة الصح
            )
        }
    }
}
