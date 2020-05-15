package com.zhou.java.Base.Jdk8NewFeature.lambda;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/11/14 15:06
 */
public class Test {


    public static void main(String[] args) {

        // 初始化
        List<Student> students = new ArrayList<Student>() {
            {
                add(new Student(20160001, "孔明", 20, 1, "土木工程", "武汉大学"));
                add(new Student(20160002, "伯约", 21, 2, "信息安全", "武汉大学"));
                add(new Student(20160003, "玄德", 22, 3, "经济管理", "武汉大学"));
                add(new Student(20160004, "云长", 21, 2, "信息安全", "武汉大学"));
                add(new Student(20161001, "翼德", 21, 2, "机械与自动化", "华中科技大学"));
                add(new Student(20161002, "元直", 23, 4, "土木工程", "华中科技大学"));
                add(new Student(20161003, "奉孝", 23, 4, "计算机科学", "华中科技大学"));
                add(new Student(20162001, "仲谋", 22, 3, "土木工程", "浙江大学"));
                add(new Student(20162002, "鲁肃", 23, 4, "计算机科学", "浙江大学"));
                add(new Student(20163001, "丁奉", 24, 5, "土木工程", "南京大学"));
            }
        };
        List<Integer> nums = new ArrayList<Integer>() {
            {
                add(1);
                add(2);
                add(1);
                add(3);
            }
        };

        System.out.println("------------------中间操作-----------------");
        System.out.println("filter:");
        List<Student> whuStudents = students.stream()
                .filter(student -> "武汉大学".equals(student.getSchool()))
                .collect(Collectors.toList());
        System.out.println(whuStudents);

        System.out.println("distinct:");
        List<Integer> evens = nums.stream()
                .filter(num -> num % 2 == 0).distinct()
                .collect(Collectors.toList());
        System.out.println(evens);

        System.out.println("limit:");
        List<Student> whuStudents2 = students.stream()
                .filter(student -> "土木工程".equals(student.getMajor())).limit(2)
                .collect(Collectors.toList());
        System.out.println(whuStudents2);

        System.out.println("sorted:");
        List<Student> sortedCivilStudents = students.stream()
                .filter(student -> "土木工程".equals(student.getMajor())).sorted((s1, s2) -> s1.getAge() - s2.getAge())
                .limit(2)
                .collect(Collectors.toList());
        System.out.println(sortedCivilStudents);

        System.out.println("skip:");
        List<Student> civilStudents = students.stream()
                .filter(student -> "土木工程".equals(student.getMajor()))
                .skip(2)
                .collect(Collectors.toList());
        System.out.println(civilStudents);

        System.out.println("map:");
        List<String> names = students.stream()
                .filter(student -> "计算机科学".equals(student.getMajor()))
                .map(Student::getName).collect(Collectors.toList());
        System.out.println(names);

        System.out.println("mapToInt:");
        int totalAge = students.stream()
                .filter(student -> "计算机科学".equals(student.getMajor()))
                .mapToInt(Student::getAge).sum();
        System.out.println(totalAge);

        System.out.println("flatMap:");
        String[] strs = {"java8", "is", "easy", "to", "use"};
        List<String> distinctStrs = Arrays.stream(strs)
                .map(str -> str.split(""))  // 映射成为Stream<String[]>
                .flatMap(Arrays::stream)  // 扁平化为Stream<String>
                .distinct()
                .collect(Collectors.toList());
        System.out.println(distinctStrs);

        System.out.println("------------------终端操作-----------------");
        System.out.println("allMatch:");
        boolean isAdult = students.stream().allMatch(student -> student.getAge() >= 18);
        System.out.println(isAdult);

        System.out.println("anyMatch:");
        boolean hasWhu = students.stream().anyMatch(student -> "武汉大学".equals(student.getSchool()));
        System.out.println(hasWhu);

        System.out.println("noneMatch:");
        boolean noneCs = students.stream().noneMatch(student -> "计算机科学".equals(student.getMajor()));
        System.out.println(noneCs);

        System.out.println("findFirst:");
        Optional<Student> optStu = students.stream().filter(student -> "土木工程".equals(student.getMajor())).findFirst();
        System.out.println(optStu);

        System.out.println("findAny:");
        Optional<Student> optStu2 = students.stream().filter(student -> "土木工程".equals(student.getMajor())).findAny();
        System.out.println(optStu2);

        System.out.println("归约reduce：");
        // 归约操作
        int totalAge2 = students.stream()
                .filter(student -> "计算机科学".equals(student.getMajor()))
                .map(Student::getAge)
                .reduce(0, (a, b) -> a + b);
        // 进一步简化
        int totalAge3 = students.stream()
                .filter(student -> "计算机科学".equals(student.getMajor()))
                .map(Student::getAge)
                .reduce(0, Integer::sum);
        // 采用无初始值的重载版本，需要注意返回Optional
        Optional<Integer> totalAge4 = students.stream()
                .filter(student -> "计算机科学".equals(student.getMajor()))
                .map(Student::getAge)
                .reduce(Integer::sum);  // 去掉初始值
        System.out.println(totalAge4);

        System.out.println("求学生的总人数:");
        long count = students.stream().count();
        System.out.println(count);

        System.out.println("maxBy求最大年龄:");
        Optional<Student> olderStudent = students.stream().collect(Collectors.maxBy((s1, s2) -> s1.getAge() - s2.getAge()));
        System.out.println(olderStudent);
        System.out.println("进一步简化:");
        Optional<Student> olderStudent2 = students.stream().collect(Collectors.maxBy(Comparator.comparing(Student::getAge)));
        System.out.println(olderStudent2);

        System.out.println("minBy求最小年龄:");
        Optional<Student> olderStudent3 = students.stream().collect(Collectors.minBy(Comparator.comparing(Student::getAge)));
        System.out.println(olderStudent3);

        System.out.println("summingInt求年龄总和:");
        int totalAge5 = students.stream().collect(Collectors.summingInt(Student::getAge));
        System.out.println(totalAge5);

        System.out.println("joining字符串拼接:");
        String names2 = students.stream().map(Student::getName).collect(Collectors.joining());
        System.out.println(names2);
        String names3 = students.stream().map(Student::getName).collect(Collectors.joining(", "));
        System.out.println(names3);

        System.out.println("并行parallelStream()：本质Fork-Join框架实现");




        List<String> list = Arrays.asList("123","2432354","23","54563677");
        list.stream().forEach(e->{
            if(e.length()>5){
                return;
            }
            System.out.println(e);
        });

    }
}
