import logo from '../../assets/img/Logo.svg';
import './styles.css';

function Header() {
    return (
        <header>
            <div className="dsmeta-logo-container">
                <img src= {logo} alt="DSMeta" />
                <h1>DSMeta</h1>
                <p>Desenvolvido por
                    <a href="https://www.instagram.com/stories/marcio.sill/2915920857218927608/"> marcio.sill@hotmail.com</a>
                </p>
            </div>
        </header>

    )
}

export default Header;