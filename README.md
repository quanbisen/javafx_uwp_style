javafx_uwp_style
=
   这是一个JavaFX写的一个模仿windows UWP应用窗口风格的JavaFX程序。如果你是喜欢JavaFX编写的UPW风格的伙伴，可以一起贡献本项目。目前已经完成了基本的最大化、最小化和退出操作，并且支持边缘自由改变窗口大小。我其实还想做把窗口拖拽到边缘，然后实现画透明矩形，然后放下鼠标完成半屏幕缩放，不过画半屏幕透明矩形还没有思路实现。

### 项目说明
   项目窗体能够**自由拖动改变位置、自由缩放、最小化、最大化和退出**。另外使用**maven**进行包管理了，如果不喜欢用maven的朋友需要下载jna-4.0.0.jar和jna-platform-4.0.0.jar两个包。JNA is Java Native Access.It provides Java programs easy access to native shared libraries (DLLs on Windows) without writing anything.因为JavaFX的stage设置了initStyle为UNDECORATED后，当窗体在前台时单击任务栏图标，windows窗体无法最小化，我在StackOverflow上面看到解决办法，就直接加进项目里了，参见链接：[StackOverflow](https://stackoverflow.com/questions/26972683/javafx-minimizing-undecorated-stage)
### 运行主界面
![主界面](https://github.com/quanbisen/JavaFX_UWP_Style/blob/master/WikiImage/First.png)
### 界面说明
我设计的颜色是灰色的，最小化、最大化和退出按钮图片背景颜色也是灰色的，当鼠标放到按钮上面，按钮的图片会切换成深色一点的图片
![放到按钮上面切换图片变色](https://github.com/quanbisen/JavaFX_UWP_Style/blob/master/WikiImage/Second.png)
单击最大化图标后的窗体能够变成最大化状态
![最大化的图片](https://github.com/quanbisen/JavaFX_UWP_Style/blob/master/WikiImage/Fourth.png)
当然，你也可以根据自己的需要更换代码中的颜色，按钮的图片需要使用Photoshop换一下背景色就可以了。如下面网易云UWP版本的
![网易云样式风格](https://github.com/quanbisen/JavaFX_UWP_Style/blob/master/WikiImage/Third.png)


