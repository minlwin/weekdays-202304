export function convert(dateStr: string) {
  let arr: any[] = []
  if(dateStr)
    arr = dateStr.split('-')

  return `${arr[1]}/${arr[0]}/${arr[2]}`
}
