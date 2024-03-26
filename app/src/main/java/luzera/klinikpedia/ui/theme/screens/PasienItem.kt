package luzera.klinikpedia.ui.theme.screens

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import luzera.klinikpedia.models.Pasien

@Composable
fun PasienItem(item: Pasien) {
    Row {
        Text(modifier = Modifier.weight(3f), text = item.namaPasien)
        Text(modifier = Modifier.weight(3f), text = item.umur)
        Text(modifier = Modifier.weight(3f), text = item.gejala)
        Text(modifier = Modifier.weight(3f), text = item.resepObat)
        Text(modifier = Modifier.weight(3f), text = item.tanggalMasuk)
    }
}
