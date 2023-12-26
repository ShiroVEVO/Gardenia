import Navbar from '../components/general/Navbar/Navbar.jsx';
import LogoViewPort from '../components/LogoViewPort/LogoViewPort.jsx';
import ProductGeneralView from '../components/ProductGeneralView/ProductGeneralView.jsx';

const LandingPage = () => {
    
    return <>
        <Navbar ubication={'landingPage'}></Navbar>
        <LogoViewPort></LogoViewPort>
        <ProductGeneralView name={'pedro'}></ProductGeneralView>
    </>
};

export default LandingPage;