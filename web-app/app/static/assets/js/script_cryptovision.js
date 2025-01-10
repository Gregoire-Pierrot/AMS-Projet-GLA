document.addEventListener('DOMContentLoaded', () => {
    const cryptoName = document.getElementById('crypto-name').textContent;
    const selectElement = document.getElementById('chart-mode');
    const optionPeriod = document.getElementById('period');
    const apiBaseUrl = '/api';
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
                    label: `Valeur de ${data.name}`,
                    data: data.values,
                    borderColor: 'rgb(75, 192, 192)',
                }]
            }
        });
    }

    async function fetchData() {
        const selectedMode = selectElement.value;
        const period = optionPeriod.value;
        const apiUrl = `${apiBaseUrl}/${selectedMode}/cryptovision/${cryptoName}/${period}`;

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

    selectElement.addEventListener('change', fetchData);
    optionPeriod.addEventListener('change', fetchData);

    setInterval(fetchData, 20000);
});
