import logo from '../../logo-for-progress-tracker.png';
import Navbar from "./Navbar";

function Header(props){
    return(
        <header className="App-header">
            <img src={logo} className="App-logo" alt="logo" />
            <Navbar change={props.changeComponent}/>
        </header>
    )
}

export default Header;