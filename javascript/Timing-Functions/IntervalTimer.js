class IntervalTimer {
  
  constructor(interval = 10, callBack = () => {}) {
    this.prevInterval = 0
    if (this.instance == null) {
      this.interval = interval
      this.callBack = callBack
      this.instance = this
    } else {
      return this.instance
    }
  }

  startTimer() {
    this.timer = setInterval(this.callBack, this.interval)
  }

  resetTimer() {
    clearInterval(this.timer)
    this.callBack = () => {}
    return this.getElapsedTime()
  }

  getElapsedTime(offset = 0) {
    this.timeElapsed = this.timer - this.prevInterval
    this.prevInterval = this.timer
    return this.timeElapsed - offset
  }

  getRunTime() {
    return this.timer
  }
}

const ExampleIntervalTimer = function (output = (v) => console.log(v)) {
  
  const timer = new IntervalTimer()
  timer.startTimer()

  const initOffset = timer.getRunTime()

  output(timer.getElapsedTime(initOffset))

  output(timer.resetTimer())
}

export { IntervalTimer, ExampleIntervalTimer }
