import "./ProductGeneralView.css";
import {useFetch} from '../../services/useFetch.js'

const ProductGeneralView = ({name}) => {
    const {data} = useFetch("http://localhost:8080/department");
    console.log("data:" + data);
    return <>
        <h1>{name}</h1>
    </>
};

export default ProductGeneralView;
