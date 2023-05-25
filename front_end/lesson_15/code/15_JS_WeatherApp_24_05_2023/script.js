const API_KEY = 'fa1e72ff893c6a4a5ed4077327e855b4'; // уникальный ключ для работы с сервером
const API_BASE_URL = 'https://api.openweathermap.org/data/2.5/weather'; // адрес сервера
/*
Константа, которая никогда не изменится - принято писать капслоком
*/
// Math.PI

const locationInput = document.getElementById('locationInput');
const getWeatherButton = document.getElementById('getWeatherButton');
const weatherContainer = document.getElementById('weatherContainer');

getWeatherButton.addEventListener('keydown', (e) => {
    console.log(e);
    if (e.code === 'Enter') {
        console.log('Мы нажали энтер :)');
    }
})

getWeatherButton.addEventListener('click', () => {
    const location = locationInput.value.trim();

    if (location) {
        const apiUrl = `${API_BASE_URL}?q=${location}&appid=${API_KEY}`;
        fetch(apiUrl)
            .then(res => res.json())
            .then(data => {
                console.log(data);
                displayWeather(data);
            })
            .catch(error => {
                console.log(error);
                weatherContainer.innerHTML = 'Failed to fetch weather data';
            });
    }
})

//Функция, отвечающая за показ погоды
function displayWeather(weatherData) {
    // С помощью деструктуризации получаем необходимые поля объекта
    const { name, sys: {country}, main, main: {humidity}, weather, wind: {speed}, visibility } = weatherData;
    
    // получаем необходимые значения из полей объекта
    // const country = sys.country;
    const temperatureC = Math.round(main.temp - 273.15); // округление (по законам математики)
    const temperatureMaxC = Math.floor(main.temp_max - 273.15); // отбрасывает знаки после запятой
    const temperatureMinC = (main.temp_min - 273.15).toFixed(1); // сколько знаков после запятой оставить
    const weatherMain = weather[0].main;
    const weatherDescription = weather[0].description;
    // const humidity = main.humidity;
    // const windSpeed = wind.speed;
    const visibilityDistance = visibility / 1000;

    //Создаем карточку для отображения инфы о погоде
    const weatherCard = document.createElement('div');

    // Добавляем класс для будущей стилизации
    weatherCard.classList.add('weather-card');

    weatherContainer.innerHTML = ''; // зачистит предыдущее значение
    
    //Помещаем контент внутрь созданной карточки
    weatherCard.innerHTML = `
        <h2>${name}, ${country}</h2>
        <p>Temperature: ${temperatureC}</p>
        <p>Max temperature: ${temperatureMaxC}</p>
        <p>Min temperature: ${temperatureMinC}</p>
        <p>Weather: ${weatherMain}</p>
        <p>Description: ${weatherDescription}</p>
        <p>Humidity: ${humidity}</p>
        <p>Wind Speed: ${speed}</p>
        <p>Visibility: ${visibilityDistance} km</p>
    `;

    weatherContainer.append(weatherCard);
}