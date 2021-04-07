const express = require('express')
const app = express()
const port = 3306

app.get('/', (req, res) => res.send('<h1>Hello World!</h1><br><br><div style="background-color:red;width:400px;height:400px;">江西软件职业技术大学</div>'))


app.listen(port, () => console.log(`Example app listening on port ${port}!`))
// 创建一个服务器连接数据库，重要