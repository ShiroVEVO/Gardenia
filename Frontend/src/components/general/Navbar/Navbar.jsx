import logo from '../../../assets/images/logo.svg'
import Toggle from '../ToggleDarkMode/ToggleDarkMode'
import './Navbar.css'

const Navbar = ({ubication}) => {
    if (ubication == "landingPage") {
        return <>
            <nav className="navbar">
                <div>
                    <a href="/catalogue">Catálogo</a>
                    <a href="/contact">Contacto</a>
                </div>
                {/* <a id="mainLogoReference" href="/"><img src={logo} id = "mainLogo" alt="Gardenia" /></a> */}
                <div id="rigthDiv">
                    <a>es</a>
                    <Toggle></Toggle>
                    <a href="/account">👨‍🌾</a>
                    <a href="/shoppingCart">🛒</a>
                </div>
            </nav>
        </>
    } else {
        return <>
        <nav className="navbar">
            <div>
                <a href="/catalogue">Catálogo</a>
                <a href="/contact">Contacto</a>
            </div>
            <a id="mainLogoReference" href="/"><img src={logo} id = "mainLogo" alt="Gardenia" /></a>
            <div id="rigthDiv">
                <a>es</a>
                <Toggle></Toggle>
                <a href="/account">👨‍🌾</a>
                <a href="/shoppingCart">🛒</a>
            </div>
        </nav>
    </>
    }
};
export default Navbar;

//https://www.youtube.com/watch?v=rLoWMU4L_qE
//https://www.youtube.com/watch?v=6u1RHUoXIPI
//https://www.youtube.com/watch?v=k1OvK7ZGN-c
