async function fetchCryptoData() {
    try {
        const response = await fetch('/api/cryptohome');
        if (!response.ok) {
            throw new Error('Erreur lors du chargement des données');
        }
        const data = await response.json();
        updateCryptoTable(data.values);
    } catch (error) {
        console.error("Erreur :", error);
    }
}

function updateCryptoTable(cryptos) {
    const tableBody = document.querySelector("#crypto-table tbody");
    tableBody.innerHTML = "";

    cryptos.forEach(crypto => {
        console.log(crypto);
        const row = document.createElement("tr");
        row.innerHTML = `
            <td>${crypto[0]}</td>
            <td>${crypto[1]}</td>
            <td>${crypto[2]}</td>
            <td>${crypto[3]}</td>
            <td>${crypto[4]}</td>
            <td>${crypto[5]}</td>
        `;
        tableBody.appendChild(row);
    });
}

setInterval(fetchCryptoData, 20000);

fetchCryptoData();