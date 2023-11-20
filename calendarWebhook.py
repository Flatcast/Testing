import datetime
import googleapiclient.discovery
import requests
from oauth2client.service_account import ServiceAccountCredentials
import logging

# Настройка логирования
logging.basicConfig(level=logging.INFO)

# Функция для получения событий, содержащих "День" и "рождения", и их дат
def get_birthday_events():
    try:
        # Авторизация и настройка сервиса
        credentials = ServiceAccountCredentials.from_json_keyfile_name('discordbot-405311-18f7e3bcafea.json', scopes=['https://www.googleapis.com/auth/calendar.readonly'])
        service = googleapiclient.discovery.build('calendar', 'v3', credentials=credentials)

        # Получение текущей даты и даты конца недели
        now = datetime.datetime.utcnow().isoformat() + 'Z'
        end_of_week = (datetime.datetime.utcnow() + datetime.timedelta(days=6)).isoformat() + 'Z'

        # Получение событий
        events_result = service.events().list(calendarId='dex769358@gmail.com', timeMin=now, timeMax=end_of_week, singleEvents=True, orderBy='startTime').execute()
        events = events_result.get('items', [])

        birthday_events = []
        for event in events:
            if 'день' in event['summary'].lower() and 'рождения' in event['summary'].lower():
                # Проверяем, есть ли дата начала в формате dateTime
                if 'dateTime' in event['start']:
                    event_date = event['start']['dateTime']
                # Если нет dateTime, проверяем наличие date
                elif 'date' in event['start']:
                    event_date = event['start']['date']
                else:
                    # Если нет ни dateTime, ни date, пропускаем событие
                    continue
                    
                birthday_events.append((event['summary'], event_date))

        return birthday_events
    except Exception as e:
        logging.error(f"Ошибка при получении событий: {e}")
        return []

# Функция для отправки сообщения в Discord через Webhook
def send_message_to_discord(webhook_url, message):
    data = {"content": message}
    response = requests.post(webhook_url, json=data)
    if response.status_code != 204:
        logging.error(f"Ошибка при отправке сообщения: {response.status_code}, {response.text}")

# Основная функция
def main():
    webhook_url = 'https://discord.com/api/webhooks/1174659980452970556/DPfTfEkCHDjYu_CucGr1FBZJMbacUG1Tx44-_uzbUhVYZp2UNTAB3ilhsY9yBC-RHjBh'
    birthday_events = get_birthday_events()

    if birthday_events:
        for event_name, event_date in birthday_events:
            formatted_date = datetime.datetime.strptime(event_date.split('T')[0], '%Y-%m-%d').strftime('%d.%m.%Y')
            send_message_to_discord(webhook_url, f"{formatted_date} {event_name}")
    else:
        send_message_to_discord(webhook_url, "Нет событий на этой неделе, содержащих 'День рождения'")

if __name__ == "__main__":
    main()
