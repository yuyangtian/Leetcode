package Stack;

import java.util.Stack;

/*
medium 27 90 时间复杂度高

题解：本题使用了三种容器来求解绝对路径

首先定义栈用来存储路径信息，定义字符数组 str 来分隔字符串

依次遍历字符数组内容，这里使用增强型 for 循环，如果是 “..” 还要再判断是否为空才能弹出栈

如果不为空也不为 “.” 这说明当前元素是路径信息，入栈即可

最后遍历完之后，先判断栈中是否有元素，没有则返回 “/”

如果有元素，则使用 StringBuilder 来存放可变字符串，最后返回 ans 即可。

代码
javajava

class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        // 首先将字符串以 “/” 分隔存储到新的字符数组 str 中
        String[] str = path.split("/");
        for (String s : str) {
            // 如果访问到的是 “..” 则说明要返回上一级,要将当前元素出栈
            if (s.equals("..") ) {
                // 还需判断栈是否为空,否则会报错
                if (!stack.isEmpty() ) {
                    stack.pop();
                }
            // 如果数组非空并且当前元素不是 “.” 说明当前元素是路径信息，要入栈
            } else if (!s.equals("") && !s.equals(".")) {
                stack.push(s);
            }
        }
        // 如果栈内没有元素说明没有路径信息，返回 “/” 即可
        if (stack.isEmpty()) {
            return "/";
        }
        // 这里用到 StringBuilder 操作字符串，效率高
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            // 这里从栈底开始拿元素
            ans.append( "/" + stack.get(i) );
        }
        return ans.toString();
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/simplify-path/solution/2020040371medianzhan-zi-fu-shu-zu-ke-bian-zi-fu-ch/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

题目：
以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。

在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。更多信息请参阅：Linux / Unix中的绝对路径 vs 相对路径

请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。最后一个目录名（如果存在）不能以 / 结尾。此外，规范路径必须是表示绝对路径的最短字符串。

 

示例 1：

输入："/home/"
输出："/home"
解释：注意，最后一个目录名后面没有斜杠。
示例 2：

输入："/../"
输出："/"
解释：从根目录向上一级是不可行的，因为根是你可以到达的最高级。
示例 3：

输入："/home//foo/"
输出："/home/foo"
解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。
示例 4：

输入："/a/./b/../../c/"
输出："/c"
示例 5：

输入："/a/../../b/../c//.//"
输出："/c"
示例 6：

输入："/a//b////c/d//././/.."
输出："/a/b/c"

 */
public class Solution_71 {
    public String simplifyPath(String path) {
        String[] buff = path.split("/");
        Stack<String> stack = new Stack<String>();
        Stack<String> stack_ = new Stack<String>();
        String result = "";
        for(String x:buff){
            if(x.equals(".")){
                continue;
            }
            if(x.equals("..")){
                if(!stack.isEmpty())
                    stack.pop();
            }
            else{
                if(!x.isEmpty())
                    stack.push(x);
            }
        }
        while(!stack.isEmpty()){
            stack_.push(stack.pop());
        }
        while(!stack_.isEmpty()){
            result += "/"+stack_.pop();
        }

        if(result.equals(""))
            return "/";
        else
            return  result;
    }
    public static void main(String args[]) {
        Solution_71 test = new Solution_71();
        System.out.println(test.simplifyPath("/a/./b/../../c/"));
    }
}
