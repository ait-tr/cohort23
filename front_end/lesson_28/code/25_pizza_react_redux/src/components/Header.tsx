import React from "react";
import Logo from "./Logo";
import Search from "./Search";
import HeaderCart from "./HeaderCart";

const Header: React.FC = () => {
    return (
        <header>
            <div>
                <Logo />
                <HeaderCart />
            </div>
            <Search />
        </header>
    );
};

export default Header;
