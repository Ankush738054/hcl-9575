import { BrowserRouter, Route, Routes } from 'react-router-dom'
import './App.css'
import SampleCode from './Component/SampleCode'
import UseFetchAPI from './Component/UseFetchAPI'
import Home from './Component/Home'
import Login from './Component/Login'
import Registration from './Component/Registration'
import Dashboard from './Component/Dashboard'

function App() {
  return (
    <>
    <BrowserRouter>
    <Routes>
      <Route path='/' element={<Home/>}></Route>
      <Route path='/login' element={<Login/>}></Route>
      <Route path='/register' element={<Registration/>}></Route>
      <Route path='/dashboard' element={<Dashboard/>}></Route>
    </Routes>
    </BrowserRouter>
    </>
  )
}

export default App
