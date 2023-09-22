export interface PageResult {
  content: any[]
  page: Page
}

export interface Page {
  current: number
  size: number
  count: number
}
