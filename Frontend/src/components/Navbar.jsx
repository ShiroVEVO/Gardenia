import logo from '../assets/logo.svg'
import './Navbar.css'

const Navbar = () => {
    return <>
       { <nav class="navbar">
            <a href="#">Catalogo</a>
            <a href="#">Contacto</a>
            <img src={logo} id = "mainLogo" alt="gardenia"/>
            <button>En/Es</button>
            <a href="#">*Icono Cuenta</a>
            <a href="#">Icono cesta</a>
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
