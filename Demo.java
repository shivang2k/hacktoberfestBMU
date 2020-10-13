class Demo
{
public static void main(String args[])
{
Thread t = Thread.currentThread();
System.out.println(t);
t.setName("First");
System.out.println(t);
System.out.println(t.getName());
System.out.println(t.getPriority());
try
{
Thread.sleep(500);
}
catch(Exception e)
{
System.out.println(e);
}
}
} 