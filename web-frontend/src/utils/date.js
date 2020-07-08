export function parseTime (time, cFormat) {
  if (arguments.length === 0) {
    return null
  }
  const format = cFormat || '{y}-{m}-{d} {h}:{i}:{s}'
  let date
  if (typeof time === 'object') {
    date = time
  } else {
    if (('' + time).length === 10) time = parseInt(time) * 1000
    date = new Date(time)
  }
  const formatObj = {
    y: date.getFullYear(),
    m: date.getMonth() + 1,
    d: date.getDate(),
    h: date.getHours(),
    i: date.getMinutes(),
    s: date.getSeconds(),
    a: date.getDay()
  }
  const timeStr = format.replace(/{(y|m|d|h|i|s|a)+}/g, (result, key) => {
    let value = formatObj[key]
    if (key === 'a') return ['一', '二', '三', '四', '五', '六', '日'][value - 1]
    if (result.length > 0 && value < 10) {
      value = '0' + value
    }
    return value || 0
  })
  return timeStr
}

export function initDatetime (date, hour, minute) {
  return new Date(date.getFullYear(), date.getMonth(), date.getDate(), hour, minute)
}

export const pickerOptions = {shortcuts: [{
  text: '最近一周',
  onClick (picker) {
    const end = new Date()
    const start = new Date()
    start.setTime(start.getTime() - 3600 * 1000 * 24 * 7)
    picker.$emit('pick', [start, end])
  }
}, {
  text: '最近一个月',
  onClick (picker) {
    const end = new Date()
    const start = new Date()
    start.setTime(start.getTime() - 3600 * 1000 * 24 * 30)
    picker.$emit('pick', [start, end])
  }
}, {
  text: '最近三个月',
  onClick (picker) {
    const end = new Date()
    const start = new Date()
    start.setTime(start.getTime() - 3600 * 1000 * 24 * 90)
    picker.$emit('pick', [start, end])
  }
}]}

export function getLongTime (value, days) {
  if (value === '') {
    return new Date().getTime() - 3600 * 1000 * 24 * days + ',' + new Date().getTime()
  } else {
    return value[0].getTime() + ',' + value[1].getTime()
  }
}

export function getDefaultTime (days, days2) {
  const dateArray = []
  if (days2 === undefined) {
    if (days > 0) {
      dateArray[0] = new Date(new Date().getTime() - 3600 * 1000 * 24 * days)
      dateArray[1] = new Date()
    } else if (days <= 0) {
      dateArray[1] = new Date(new Date().getTime() - 3600 * 1000 * 24 * days)
      dateArray[0] = new Date()
    }
  } else {
    dateArray[0] = new Date(new Date().getTime() - 3600 * 1000 * 24 * days)
    dateArray[1] = new Date(new Date().getTime() + 3600 * 1000 * 24 * days2)
  }
  return dateArray
}
