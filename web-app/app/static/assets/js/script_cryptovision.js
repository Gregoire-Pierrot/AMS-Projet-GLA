document.addEventListener('DOMContentLoaded', () => {
    const cryptoName = document.getElementById('crypto-name').textContent; // Change le nom selon l'URL actuelle ou fais-le dynamique
    const apiUrl = `/api/cryptovision/${cryptoName}`;
    console.log(apiUrl);

    const ctx = document.getElementById('crypto-chart').getContext('2d');
    let currentChart;

    function updateChart(data) {
        if (currentChart) {
            currentChart.destroy();
        }

        currentChart = new Chart(ctx, {
            type: 'line',
            data: {
                labels: data.times,
                datasets: [{
                    label: `Prix de ${data.name}`,
                    data: data.values,
                    borderColor: 'rgb(75, 192, 192)',
                }]
            }
        });
    }

    async function fetchData() {
        try {
            const response = await fetch(apiUrl);
            const data = await response.json();

            console.log(data.name, data.values, data.times);

            document.getElementById('crypto-name').textContent = data.name;

            updateChart(data);
        } catch (error) {
            console.error("Erreur lors de la récupération des données de l'API :", error);
            alert("Impossible de charger les données du graphique.");
        }
    }

    fetchData();

    setInterval(fetchData, 20000);
});
