# ItemReplacer

**ItemReplacer** — это гибкий и настраиваемый плагин для замены предметов по различным параметрам, с поддержкой конфигурационных файлов и команд для удобного управления заменами. Плагин также предоставляет API для интеграции в другие проекты.

> ⚠️ **Плагин находится на стадии разработки и ещё не тестировался. Возможны баги и недоработки.**

## Особенности

- Поддержка команд для изменения и управления заменами без необходимости перезагрузки сервера.
- API для разработчиков для расширения функционала и интеграции с другими плагинами.
- Интеграция через Google Guice для удобной работы с зависимостями.
- Использование Jackson для обработки данных в формате YAML и других.
- Удобный CommandFramework для регистрации и обработки команд.

## Основной функционал

- Настройка замены предметов по различным параметрам: ID, метаданным, названию и другим характеристикам.
- Динамическое создание и редактирование правил замены прямо в игре.
- Простая система команд для игроков и администраторов для управления заменами.

## Зависимости

- **Jackson** — для работы с JSON.
- **CommandFramework** — для обработки и регистрации команд.
- **Google Guice** — для инъекций зависимостей.

## API

Плагин предоставляет API, которое разработчики могут использовать для интеграции системы замены предметов в свои собственные плагины.