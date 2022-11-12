package main

import "time"

import "fmt"

func main() {

	//新建计时器，两秒以后触发，go触发计时器的方法比较特别，就是在计时器的channel中发送值

	timer1 := time.NewTimer(time.Second * 2)

	//此处在等待channel中的信号，执行此段代码时会阻塞两秒

	<-timer1.C

	fmt.Println("Timer 1 expired")

	//新建计时器，一秒后触发

	timer2 := time.NewTimer(time.Second)

	//新开启一个线程来处理触发后的事件

	go func() {

		//等触发时的信号

		<-timer2.C

		fmt.Println("Timer 2 expired")

	}()

	//由于上面的等待信号是在新线程中，所以代码会继续往下执行，停掉计时器

	stop2 := timer2.Stop()

	if stop2 {

		fmt.Println("Timer 2 stopped")

	}
	go func() {
		for t := range time.Tick(time.Minute) {
			fmt.Println("Tick at", t)
		}
	}()

	// 使用time.Ticker
	var ticker *time.Ticker = time.NewTicker(1 * time.Second)

	go func() {
		for t := range ticker.C {
			fmt.Println("Tick at", t)
		}
	}()

	time.Sleep(time.Second * 5)
	ticker.Stop()
	fmt.Println("Ticker stopped")

}
