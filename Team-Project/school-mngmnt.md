
# 🎓 SIMPLIFIED SCHOOL MANAGEMENT SYSTEM


## 🎯 CORE RULES

* Each **feature = one class**
* Each class is **owned by 2–3 students**
* Central `School` class holds everything
* `Menu` controls flow
* Use **ArrayList**, constructors, getters/setters

---

## 🧠 SYSTEM IDEA (VERY SIMPLE)

* Admin can:

  * Add students
  * Add teachers
  * Add courses
  * Record attendance
  * Enter results
  * View records

---

## 📐 SIMPLE CLASS DIAGRAM

```
                Main
                 |
               Menu
                 |
               School
     ┌───────┬────────┬────────┬────────┬────────┐
     |       |        |        |        |        |
 Student   Teacher   Course  Attendance  Result   Fee
```

---

## 📁 PROJECT FOLDER STRUCTURE

```
SchoolManagement/
└── src/
    ├── core/
    │   ├── School.java
    │   └── Menu.java
    ├── model/
    │   ├── Student.java
    │   ├── Teacher.java
    │   ├── Course.java
    │   ├── Attendance.java
    │   ├── Result.java
    │   └── Fee.java
    └── Main.java
```

---

# 🧩 STARTER CODE (EVERYONE USES THIS)

---

## 1️⃣ `model/Student.java`

**(Student Module – 2–3 students)**

```java
package model;

public class Student {
    private int id;
    private String name;
    private String level;

    public Student(int id, String name, String level) {
        this.id = id;
        this.name = name;
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLevel() {
        return level;
    }

    public String toString() {
        return id + " - " + name + " (" + level + ")";
    }
}
```

---

## 2️⃣ `model/Teacher.java`

**(Teacher Module – 2 students)**

```java
package model;

public class Teacher {
    private int id;
    private String name;
    private String courseAssigned;

    public Teacher(int id, String name, String courseAssigned) {
        this.id = id;
        this.name = name;
        this.courseAssigned = courseAssigned;
    }

    public String toString() {
        return id + " - " + name + " (Course: " + courseAssigned + ")";
    }
}
```

---

## 3️⃣ `model/Course.java`

**(Course Module – 2 students)**

```java
package model;

public class Course {
    private String code;
    private String title;

    public Course(String code, String title) {
        this.code = code;
        this.title = title;
    }

    public String toString() {
        return code + " - " + title;
    }
}
```

---

## 4️⃣ `model/Attendance.java`

**(Attendance Module – 2–3 students)**

```java
package model;

public class Attendance {
    private int studentId;
    private String courseCode;
    private boolean present;

    public Attendance(int studentId, String courseCode, boolean present) {
        this.studentId = studentId;
        this.courseCode = courseCode;
        this.present = present;
    }

    public String toString() {
        return "Student ID: " + studentId +
               ", Course: " + courseCode +
               ", Present: " + present;
    }
}
```

---

## 5️⃣ `model/Result.java`

**(Result Module – 2–3 students)**

```java
package model;

public class Result {
    private int studentId;
    private String courseCode;
    private int score;

    public Result(int studentId, String courseCode, int score) {
        this.studentId = studentId;
        this.courseCode = courseCode;
        this.score = score;
    }

    public String getGrade() {
        if (score >= 70) return "A";
        if (score >= 60) return "B";
        if (score >= 50) return "C";
        if (score >= 45) return "D";
        return "F";
    }

    public String toString() {
        return "Student ID: " + studentId +
               ", Course: " + courseCode +
               ", Score: " + score +
               ", Grade: " + getGrade();
    }
}
```

---

## 6️⃣ `model/Fee.java`

**(Fee Module – 2 students)**

```java
package model;

public class Fee {
    private int studentId;
    private double totalFee;
    private double paidAmount;

    public Fee(int studentId, double totalFee, double paidAmount) {
        this.studentId = studentId;
        this.totalFee = totalFee;
        this.paidAmount = paidAmount;
    }

    public double getBalance() {
        return totalFee - paidAmount;
    }

    public String toString() {
        return "Student ID: " + studentId +
               ", Balance: " + getBalance();
    }
}
```

---

## 7️⃣ `core/School.java`

**(Central Storage – 2 students)**

```java
package core;

import model.*;
import java.util.ArrayList;

public class School {

    public ArrayList<Student> students = new ArrayList<>();
    public ArrayList<Teacher> teachers = new ArrayList<>();
    public ArrayList<Course> courses = new ArrayList<>();
    public ArrayList<Attendance> attendanceList = new ArrayList<>();
    public ArrayList<Result> results = new ArrayList<>();
    public ArrayList<Fee> fees = new ArrayList<>();

    public void addStudent(Student s) {
        students.add(s);
    }

    public void addTeacher(Teacher t) {
        teachers.add(t);
    }

    public void addCourse(Course c) {
        courses.add(c);
    }
}
```

---

## 8️⃣ `core/Menu.java`

**(Menu & Control – 3 students)**

```java
package core;

import model.*;
import java.util.Scanner;

public class Menu {

    private School school = new School();
    private Scanner sc = new Scanner(System.in);

    public void show() {

        while (true) {
            System.out.println("\n=== School Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Name: ");
                String name = sc.nextLine();

                System.out.print("Level: ");
                String level = sc.nextLine();

                school.addStudent(new Student(id, name, level));
                System.out.println("Student added!");

            } else if (choice == 2) {
                for (Student s : school.students) {
                    System.out.println(s);
                }

            } else if (choice == 3) {
                break;
            }
        }
    }
}
```

---

## 9️⃣ `Main.java`

```java
import core.Menu;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.show();
    }
}
```

---

# 👥 TASK ASSIGNMENT (20 STUDENTS)

| Module             | Students |
| ------------------ | -------- |
| Student            | 3        |
| Teacher            | 2        |
| Course             | 2        |
| Attendance         | 3        |
| Result             | 3        |
| Fee                | 2        |
| School (Core)      | 2        |
| Menu / Integration | 3        |

---