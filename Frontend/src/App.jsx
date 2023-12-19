import './App.css'
import Navbar from './components/Navbar.jsx'
import ToggleDarkMode from './components/general/ToggleDarkMode.jsx'


function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <ToggleDarkMode></ToggleDarkMode>
    </>
  )
}

export default App
