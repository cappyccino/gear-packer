import Logo from './logo.svg'
import './Header.scss'

const Header = () => {
    return <div className="header">
        <div className="header__logo" role="img" aria-label="the Gear Packer logo">
            <Logo/>
        </div>
        <div className="header__title" role="heading" aria-level="1">
            Gear Packer
        </div>
    </div>
}

export default Header
