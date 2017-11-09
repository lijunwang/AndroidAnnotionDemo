# AndroidAnnotionDemo
基于反射的注解Demo

# Java反射

## 基本定义，动态获取类或对象的信息及方法

### 对于任意一个类，都能够知道这个类的所有属性和方法

### 对于任意一个对象，都能够调用它的任意一个方法和属性

## 获取类的三种方法

### Class c1 = Programma.class

### Programma p = new Programma("Wanglijun");Class c2 = p.getClass()

### Class c3 = Class.forName("com.wlj.test.reflect.Programma");

## 实例化的二种方法

### Programma p2 = (Programma) c1.newInstance();

#### 注意事项

##### 一定要有个非私有的无参构造方法

### Constructor constructor = c1.getDeclaredConstructor(String.class,int.class);
			constructor.isAccessible();
			constructor.setAccessible(true);
			Programma p3 = (Programma) constructor.newInstance("WLJ", 25);

#### 优势，相比于第一种，明显更加灵活，可以无参构造方法，也可以其构造方法为私有的（constructor.setAccessible(true)即可）。

