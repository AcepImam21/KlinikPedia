package luzera.klinikpedia.ui.theme.screens


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.benasher44.uuid.uuid4
import luzera.klinikpedia.persistences.PasienDao
import luzera.klinikpedia.models.Pasien
import kotlinx.coroutines.launch

@Composable
fun FormPasienScreen(pasienDao: PasienDao) {

    val scope = rememberCoroutineScope()

    val namaPasien = remember { mutableStateOf(TextFieldValue("")) }
    val umur = remember { mutableStateOf(TextFieldValue("")) }
    val gejala = remember { mutableStateOf(TextFieldValue("")) }
    val resepObat = remember { mutableStateOf(TextFieldValue("")) }
    val tanggalMasuk = remember { mutableStateOf(TextFieldValue("")) }

    Column(modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth()) {

        OutlinedTextField(
            label = { Text(text = "Nama Pasien") },
            modifier = Modifier.fillMaxWidth(),
            value = namaPasien.value, onValueChange = {
                namaPasien.value = it
            })

        OutlinedTextField(
            label = { Text(text = "Umur") },
            modifier = Modifier.fillMaxWidth(),
            value = umur.value, onValueChange = {
                umur.value = it
            })

        OutlinedTextField(
            label = { Text(text = "Gejala") },
            modifier = Modifier.fillMaxWidth(),
            value = gejala.value, onValueChange = {
                gejala.value = it
            })

        OutlinedTextField(
            label = { Text(text = "Resep Obat") },
            modifier = Modifier.fillMaxWidth(),
            value = resepObat.value, onValueChange = {
                resepObat.value = it
            })

        OutlinedTextField(
            label = { Text(text = "Tanggal Masuk") },
            modifier = Modifier.fillMaxWidth(),
            value = tanggalMasuk.value, onValueChange = {
                tanggalMasuk.value = it
            })

        Spacer(modifier = Modifier.height(16.dp)) // Spacer untuk menambah jarak

        Row {
            Button(modifier = Modifier.weight(5f), onClick = {
                val item = Pasien(
                    uuid4().toString(),
                    namaPasien.value.text,
                    umur.value.text,
                    gejala.value.text,
                    resepObat.value.text,
                    tanggalMasuk.value.text
                )
                scope.launch {
                    pasienDao.upsert(item)
                }
                namaPasien.value = TextFieldValue("")
                umur.value = TextFieldValue("")
                gejala.value = TextFieldValue("")
                resepObat.value = TextFieldValue("")
                tanggalMasuk.value = TextFieldValue("")
            }) {
                Text(text = "Simpan")
            }

            Spacer(modifier = Modifier.width(16.dp)) // Spacer untuk menambah jarak horizontal

            Button(modifier = Modifier.weight(5f), onClick = {
                namaPasien.value = TextFieldValue("")
                umur.value = TextFieldValue("")
                gejala.value = TextFieldValue("")
                resepObat.value = TextFieldValue("")
                tanggalMasuk.value = TextFieldValue("")
            }) {
                Text(text = "Batal")
            }
        }
    }
}

