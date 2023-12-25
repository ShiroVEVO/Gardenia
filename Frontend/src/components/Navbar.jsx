import logo from '../assets/logo.svg'
//import Button from './general/Button'
import Toggle from './general/ToggleDarkMode'
import './Navbar.css'

const Navbar = () => {
    return <>
       { <nav class="navbar">
            <div>
                <a href="/catalogue">Catálogo</a>
                <a href="/contact">Contacto</a>
            </div>
            <a id="mainLogoReference" href="/"><img src={logo} id = "mainLogo" alt="gardenia"/></a>
            <div id="rigthDiv">
                <a>es</a>
                <Toggle></Toggle>
                <a href="/account">👨‍🌾</a>
                <a href="/shoppingCart">🛒</a>
            </div>
        </nav>}
    </>
};
//https://www.youtube.com/watch?v=amf18mxNX18
export default Navbar;

/*const Video = ({title, description, duration}) => {
    let seconds = duration % 60;
    let minutes = Math.floor(duration/60);
    return <>
        <h3>{title}</h3>
        <div>
            <p>duration: {minutes}:{seconds}</p>
            <p>{description}</p>
        </div>
    </>
};

export default Video;*/

//https://www.youtube.com/watch?v=rLoWMU4L_qE
//https://www.youtube.com/watch?v=6u1RHUoXIPI
//https://www.youtube.com/watch?v=k1OvK7ZGN-c
