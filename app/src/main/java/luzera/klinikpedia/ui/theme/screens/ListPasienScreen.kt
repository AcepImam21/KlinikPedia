package luzera.klinikpedia.ui.theme.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.LiveData
import luzera.klinikpedia.models.Pasien
import luzera.klinikpedia.persistences.PasienDao

@Composable
fun ListPasienScreen(pasienDao: PasienDao) {

    val _list: LiveData<List<Pasien>> = pasienDao.loadAll()
    val list: List<Pasien> by _list.observeAsState(listOf())

    Column(modifier = Modifier.fillMaxWidth()) {
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(list.size) { index ->
                val item = list[index]
                PasienItem(item = item)
            }
        }
    }
}

