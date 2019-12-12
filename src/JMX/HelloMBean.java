package JMX;

/**
 * @author wangliang01 on 2018/9/11 using IDEA.
 */
public interface HelloMBean
{
    public String getName();

    public void setName(String name);

    public String getAge();

    public void setAge(String age);

    public void helloWorld();

    public void helloWorld(String str);

    public void getTelephone();
}