# 二分搜索算法
### 1、概述 
&ensp;&ensp;&ensp;&ensp;在计算机科学中，**二分搜索**（*binary search*），也称**折半搜索**（*half-interval search*）、**对数搜索**（*logarithmic search*），是一种在有序数组中查找某一特定元素的搜索算法。搜索过程从数组的中间元素开始，如果中间元素正好是要查找的元素，则搜索过程结束；如果某一特定元素大于或者小于中间元素，则在数组大于或小于中间元素的那一半中查找，而且跟开始一样从中间元素开始比较。如果在某一步骤数组为空，则代表找不到。这种搜索算法每一次比较都使搜索范围缩小一半。 
<style>
table
{
    margin: auto;
}
</style>
|      | Description |
| :----: |:----: |
| 中文名     | 二分搜索       |
| 外文名   | *binary search*   |
| 又称     |折半搜索、对数搜索   |
|  类别    |     搜索算法     |
|  数据结构  |    数组  |
<br>  
### 2、算法原理
&ensp;&ensp;&ensp;&ensp;二分查找原理很简单，针对有序数组的查找效率也很高。具体原理为，每次拿目标数值（以下用value表示）与数组中间位置的数据（以下用arry[mid]表示，mid表示数组中间位置索引值）进行比较，如果value大于arry[mid]，继续将value与大于arry[mid]部分的中间位置的值进行比较；如果value小于arry[mid]，继续将value与小于arry[mid]部分的中间位置值进行比较。  


<font color=red>注：对于无序数组，若先进行排序，再使用二分查找，这种方法虽然可以实现查找，但是会改变最原始数组的元素位置，所以针对无序数组，最好用基本的查找算法实现</font>

**原理图如下：**    

![二分搜索算法示例](https://img-blog.csdnimg.cn/fbd0e6303a5c4e89a16dc5de41dcdb92.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA5LuZ5bqm55Ge5ouJ5b-r6LeR,size_20,color_FFFFFF,t_70,g_se,x_16#pic_center)
<br>

### 3、复杂性分析
（1）时间复杂性: 折半搜索每次把搜索区域减少一半，时间复杂度为 $ O(logn ) $     

（2）空间复杂性: $ O(1)$，虽以递归形式定义，但是尾递归，可改写为循环。
<br>

### 4、示例代码   
&ensp;&ensp;**C语言**
```c
int binary_search(const int arr[], int start, int end, int key) {
    int ret = -1;       // 未搜索到数据返回-1下标
     
int mid;
while (start <= end) {
mid = start + (end - start) / 2; //直接平均可能会溢位，所以用此算法
if (arr[mid] < key)
start = mid + 1;
else if (arr[mid] > key)
end = mid - 1;
else {            
ret = mid;  
            break;
        }
}
 
return ret;     // 单一出口
}
```
     
**Java递归**     
```java
public static int binarySearch(int[] arr, int start, int end, int hkey){
    if (start > end)
        return -1;
  
    int mid = start + (end - start)/2;    //防止溢位
    if (arr[mid] > hkey)
        return binarySearch(arr, start, mid - 1, hkey);
    if (arr[mid] < hkey)
        return binarySearch(arr, mid + 1, end, hkey);
    return mid;  
  
}
```


<br>

### 参考引用
[二分搜索算法百度百科](https://baike.baidu.com/item/%E4%BA%8C%E5%88%86%E6%90%9C%E7%B4%A2%E7%AE%97%E6%B3%95/4081752?fr=aladdin)