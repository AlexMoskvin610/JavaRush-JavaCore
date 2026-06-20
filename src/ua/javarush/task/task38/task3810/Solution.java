package ua.javarush.task.task38.task3810;

/* 
Реалізуй анотації
*/

@Changelog( {
        @Revision(
                revision = 4089,
                date = @Date(year = 2011, month = 5, day = 30, hour = 18, minute = 35, second = 18),
                comment = "Новий файл додано"),
        @Revision(
                revision = 6018,
                date = @Date(year = 2013, month = 1, day = 1, hour = 0, minute = 0, second = 1),
                authors = {@Author(value = "Сергій", position = Position.MIDDLE)},
                comment = "Фікс багів"),
        @Revision(
                revision = 10135,
                date = @Date(year = 2014, month = 12, day = 31, hour = 23, minute = 59, second = 59),
                authors = {@Author(value = "Діана", position = Position.OTHER),
                        @Author("Ігор"),
                        @Author(value = "Віктор", position = Position.SENIOR)})
})
public class Solution {
    public static void main(String[] args) {
        System.out.println(Solution.class.getAnnotation(Changelog.class).toString());
    }
}
