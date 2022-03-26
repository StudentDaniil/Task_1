22. Описать класс для представления Тарифов на международную связь. Данный класс 
хранит в себе список направлений в виде код (префикс) направления, название 
направления, цена минуты разговора. Класс должен уметь загружать информацию из 
текстового файла заданного формата (проще всего csv), сохранять тарифы в такой же 
файл, иметь возможность добавления/удаления/модификации направления. И самое 
главное, класс должен уметь считать стоимость звонка, заданного вызываемым номером 
и длительностью в секундах. Для этого надо найти направление с самым длинным кодом 
(префиксом), подходящим к номеру, перевести длительность звонка в минуты (с 
округлением вверх, звонки короче 6 секунд не тарифицируются). Интерфейс для 
демонстрации может быть консольным.