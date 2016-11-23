# Fragment 各种状态下的生命周期
先扔出生命周期图
![](http://ww2.sinaimg.cn/large/801b780agw1f9psjd9e6zj208t0njjt2.jpg)
							关于 Fragment 请参考[官网](https://developer.android.com/guide/components/fragments.html)

## 静态添加
###添加步骤
在xml布局中使用 `<fragment>` 标签,在**activity:name**属性中添加对应Fragment
**需要注意的是：**
fragment 必须要有唯一标示 三者任选其一

* **android:id** 属性
* **android:tag** 属性
* 如果没有则会自动选取 选取容器的id，如果容器也没有id 则会抛出**RuntimeException**

###生命周期
#### 初始化
![](http://ww2.sinaimg.cn/large/65e4f1e6jw1fa15wjrzt7j20go08mtb2.jpg)
Activity: onCreate
Fragment: onAttach
Fragment: onCreate
Fragment: onCreateView
Fragment: onAtivityCreated
Fragment: onStart
Activity: onStart
Activity: onResume
Fragment: onResume
可以看出 Fragment 是跟随setContentView 生成的
##### Back键
![](http://ww2.sinaimg.cn/large/006y8lVagw1f9iisa8mc8j30ey07stao.jpg)
Fragment: onPause
Activity: onPause
Fragment: onStop
Activity: onStop
Fragment: onDestoryView
Fragment: onDestory
Fragment: onDestach
Activity: onDestory
#### 点击Home键
![](http://ww3.sinaimg.cn/large/006y8lVagw1f9iinkwc2tj30dw03ygmg.jpg)
Fragment: onPause
Activity: onPause
Fragment: onStop
Activity: onStop
#### 多任务键返回
![](http://ww1.sinaimg.cn/large/006y8lVagw1f9iiq77e84j30ew04ot9x.jpg)
Activity: onRestart
Fragment: onSstart
Activity: onResume
Fragment: onResume
#### 点击Home被杀死
重新走生命周期了，这个先不详细讨论

##动态添加
通过代码将 `Fragment` 添加到现有的`ViewGroup`中
通过 `FragmentManager` 管理 `fragment`
通过`FragmentTransaction` 事务提交的方式 `add`,`remove`,`replace`,`show`,`hide`,`attach`,`detach`
### add remove replace
####add
![](http://ww1.sinaimg.cn/large/65e4f1e6jw1fa15zzgs21j20fq05s0u8.jpg)
Fragment: onAttach
Fragment: onCreate
Fragment: onCreateView
Fragment: onActivityCreated
Fragment: onStart
Fragment: onResume
####remove
![](http://ww3.sinaimg.cn/large/801b780agw1f9psnzb5j7j20ec04ujsj.jpg)
Fragemnt: onPause
Fragment: onStop
Fragment: onDestoryView
Fragment: onDestory
Fragment: onDetach
####replace
replace = add + remove
**remove replace 方式会导致生命周期重启，所有用户数据会丢失**

### show & hide
不走生命周期，实例保存
### attach & detach
#### attach
![](http://ww4.sinaimg.cn/large/65e4f1e6jw1fa1622p3zjj20fs03qgmk.jpg)
Fragment: onCreateView
Fragment: onActivityCreated
Fragment: onStart
Fragment: onResume
没有onCreate 方法
#### detach
![](http://ww4.sinaimg.cn/large/801b780agw1f9ptgam8dzj20ei030mxs.jpg)
Fragment: onPause
Fragment: onStop
Fragment: onDestoryView
##总结
因为 add remove replace 都会重新走生命周期所以不需要保存用户状态就直接 使用 `add` `removew` `replace` 添加和替换就可以了
如果需要保存用户状态 用 `show` `hide`
## 添加到 back stack
当Fragment 添加到 back stack 中生命周期会受到影响
![](http://ww3.sinaimg.cn/large/65e4f1e6jw1fa167dm0k7j20fo08gq5c.jpg)
点击button添加到 back stack
![](http://ww2.sinaimg.cn/large/801b780agw1f9t8rvbhacj20fs02qaap.jpg)
Fragment: onAttach
Fragment: onCreate
Fragment: OnCreateView
Fragment: onActivityCreated
Fragment: onStart
replace addToBackStack
Fragment: onPause
Fragment: onStop
Fragment: onDestoryView
**不会 onDestory onDetach**

![](http://ww4.sinaimg.cn/large/65e4f1e6jw1fa169855fpj20gk03qwfi.jpg)
点击返回键
Fragment: onCreateView
Fragment: onActivityCreated
Fragment: onStart
Fragment: onResume
**不会走 onAttach onCreated**
## ViewPager
### 添加到 FragmentPagerAdapter
一般使用`ViewPager` 使用 `FragmentPagerAdapter`，`FragmentPagerAdapter` 使用 `FragmentManager` 管理`Fragment`，每个访问过的 `Fragment` 都会存在内存中
三个 `Fragmetn` 的例子
启动
![](http://ww1.sinaimg.cn/large/65e4f1e6jw1fa16b614ykj20fs0batbz.jpg)
`fragment01` 处于屏幕
切换
![](http://ww1.sinaimg.cn/large/65e4f1e6jw1fa16bsj4xkj20fm05iwg0.jpg)
`fragment02` 处于屏幕
可以看出切换到中部三个 `Fragment` 都处于onResume状态
再切换
`fragment03` 处于屏幕
![](http://ww4.sinaimg.cn/large/65e4f1e6jw1fa157i7zdcj20f8030wf3.jpg)
当第三个 `fragment03` 显示在屏幕上，第一个 `fragment01` onDestoryView
再次切换
`fragment02` 处于屏幕
![](http://ww2.sinaimg.cn/large/65e4f1e6jw1fa16d7kus7j20fs03q3zf.jpg)
`fragment01` 处于 `onResume` 可以看出只是 执行 `onCreateView` -> `onActivityCreated` -> `onStart` -> `onResume` **没有执行** `onAttach` `onCreate` `onCreateView`

### 添加到 FragmentStatePagerAdapter
过程和 FragmentPagerAdapter 一样 看图吧
![](http://ww1.sinaimg.cn/large/65e4f1e6jw1fa16ertm16j20go06qdhq.jpg)
切换
![](http://ww4.sinaimg.cn/large/65e4f1e6jw1fa16f7tmqej20fm05sta8.jpg)
切换
![](http://ww3.sinaimg.cn/large/65e4f1e6jw1fa16fmuqn5j20f402s0tc.jpg)
切换
![](http://ww3.sinaimg.cn/large/65e4f1e6jw1fa16g1dn2qj20fu03s0to.jpg)
### 总结
一般静态添加少量 `Fragment` 用 `FragmentPagerAdapter`
动态大量添加 `Fragment` 用 `FragmentStatePagerAdapter`











