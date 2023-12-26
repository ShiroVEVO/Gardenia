import logo from '../../assets/images/logo.svg'
import './LogoViewPort.css';


const LogoViewPort = () =>{
    return <div id="logoViewPort">
        <a id="mainLogoReference" href="/"><img src={logo} id = "mainLogo" alt="Gardenia" /></a>
    </div>
};

export default LogoViewPort;