# Swing sample

**Первая лаба по ППвИС за четвёртый семестр с доп. заданием**

# Задание:

Создать виджет, который содержит пять групп элементов управления (для
группировки использовать QGroupBox ) со следующей логикой:
1. Cостоит из элементов QLineEdit , QComboBox , QPushButton . Пользователь заносит
текст в QLineEdit , затем нажимает элемент QPushButton , после чего текст из
QLineEdit
заносится в элемент QComboBox . Если вносимый текст уже существует в
QComboBox ,
то при добавлении должно быть выведено диалоговое окно о
невозможности добавления.
2. Состоит из элементов QLineEdit , QPushButton1 , QPushButton2 . Пользователь
заносит текст в QLineEdit , затем нажимает элемент QPushButton1 , после чего
текст из QLineEdit отображается на элементе QPushButton2 . При нажатии на
QPushButton2
тексты на кнопках меняются местами.
3. Состоит из элементов QLineEdit , QPushButton , QRadioButton1 , QRadioButton2 ,
QRadioButton3 .
Пользователь заносит имя одного из элементов типа QRadioButton
в QLineEdit , затем нажимает элемент QPushButton , после чего соответствующий
элемент помечается, причем со всех остальных пометки должны сниматься (для
этого использовать QButtonGroup ). При повторном нажатии на QPushButton метка
с уже выделенного элемента QRadioButton не должна исчезать. Если введено имя
QRadioButton ,
которого не существует, то должно быть выведено диалоговое окно
с ошибкой.
4. Состоит из элементов QLineEdit , QPushButton ,
QCheckBox3 .
QCheckBox1 ,
QCheckBox2 ,
Пользователь заносит имена элементов QCheckBox в QLineEdit , затемнажимает элемент QPushButton , после чего соответствующий элемент помечается.
Если введено имя QCheckBox , которого не существует, то должно быть выведено
диалоговое окно с ошибкой.
5. Состоит из элементов QLineEdit , QPushButton1 , QPushButton2 , QPushButton3 ,
QTableWidget ( QTableWidget
– состоит из двух столбцов). Пользователь заносит
текст в QLineEdit , затем нажимает элемент QPushButton1 , после чего текст из
QLineEdit
заносится в первый столбец элемента QTableWidget . Затем нажимает
элемент QPushButton2 , после чего выделенный текст из первого столбца
QTableWidget
переноситься во второй столбец элемента QTableWidget в той же
строке, затем нажимает элемент QPushButton3 , после чего выделенный текст из
второго столбца QTableWidget переносится
QTableWidget
в первый столбец элемента
в той же строке. В элементе управления QTableWidget в каждой
строке один столбец всегда остается пустым.

# Дополнительное задание:

Написать LayoutManager который будет распологать все элементы по кругу. **На ветке circle-layout**.

# Запуск

```bash
javac src/MainFrame.java && java src.Main
```
