## Profile工具介绍
Profiling tools是IDEA自带的一个对于探索哪些方法在大多数时间运行非常有用的分析工具。   
详情的介绍可以查看官方文档
[IDEA官方文档关于Profiling tools介绍](https://www.jetbrains.com/help/idea/cpu-profiler.html)
和这个知乎博客[IDEA集成Async Profiler](https://zhuanlan.zhihu.com/p/81886875)

## Profile的使用
### 编写一个排序代码
我是写了一个选择排序的java代码，先随机生成一个数组，再利用选择排序的方式排序，代码如下
```java
public class SortPro {
    public static int[] selectionSort(int[] arr){
        if(arr.length==0)
            return arr;
        for(int i=0;i<arr.length;i++){
            int minIndex = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[minIndex]){
                    minIndex =j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i]=temp;
        }
        return arr;
    }

    public static void main(String[] args){
        int[] arr = new int[20];
        System.out.println("随机生成的数组如下");
        for(int i=0;i<20;i++){
            arr[i]=(int)(Math.random()*100);
            System.out.print(arr[i]+" ");
        }
        System.out.println("\n排序后如下：");
        arr = selectionSort(arr);
        for(int i=0;i<20;i++){
            System.out.print(arr[i]+" ");
        }

    }
}

```

### 运行
写好代码后，在上方的工具栏选择   
<br>
![在这里插入图片描述](https://img-blog.csdnimg.cn/f007efb7ddac4344b2e8cbec99754b6c.png#pic_center)    
<br>

![在这里插入图片描述](https://img-blog.csdnimg.cn/e8cf6baf08874d6c9352b6bd7bad6697.png#pic_center)     

运行后，在下方有如下显示，选择“open”打开，就可以看到结果      

![在这里插入图片描述](https://img-blog.csdnimg.cn/7f1b7eb62059404abfb021e2a2fd9597.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA5LuZ5bqm55Ge5ouJ5b-r6LeR,size_17,color_FFFFFF,t_70,g_se,x_16#pic_center)
      
      

### 结果展示   

1、**火焰图**：     

![在这里插入图片描述](https://img-blog.csdnimg.cn/6d3a762606dd4f64bdedfde9e661519b.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA5LuZ5bqm55Ge5ouJ5b-r6LeR,size_20,color_FFFFFF,t_70,g_se,x_16#pic_center)       


![在这里插入图片描述](https://img-blog.csdnimg.cn/a38a7ed7f0ac43c29d97f73117881edc.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA5LuZ5bqm55Ge5ouJ5b-r6LeR,size_20,color_FFFFFF,t_70,g_se,x_16#pic_center)      
     
     
![在这里插入图片描述](https://img-blog.csdnimg.cn/5bc8e56468014bb4a91cc9dc2e0d5828.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA5LuZ5bqm55Ge5ouJ5b-r6LeR,size_20,color_FFFFFF,t_70,g_se,x_16#pic_center)         

   
### 结果分析
&ensp;&ensp; 从火焰图中，可以看出，main函数占CPU的时间比较少，而被调用的sort函数占比较多，即对数组的排序耗时较多；在点击火焰图中的蓝色部分，可查看相应的信息，也可以发现该函数的比较操作最为耗时，而交换两个元素耗时次之。    
&ensp;&ensp; 在调用树这幅图中，可以明显看到，sort函数占用了CPU绝大部分的时间。
&ensp;&ensp; 此外，还可以在工具中查看程序运行时的时间线，即timeline。

**推荐**
&ensp;&ensp; 在此次学习Profile工具时，也了解到在JAVA中常用的性能监控工具Jprofiler，它比Profile更能直观地观察程序的性能，它具有以下优点：   
1、  CPU,Thread,Memory分析功能尤其强大

2、  支持对jdbc,慢Sql监控,jsp, servlet, socket等进行分析

3、  支持多种模式(离线，在线)的分析

4、  支持IDEA、eclipse插件，若在生产过程中识别代码性能问题将能解决大部分性能问题。保守在30~50%左右。

5、 支持跨平台：windows、liunx、macos...

  如果想更深入地学习这方面，可以参考相关资料学习和使用。 