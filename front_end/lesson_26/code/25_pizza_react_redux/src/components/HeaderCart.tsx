import React from "react";
import { useSelector } from "react-redux";
import { selectCart } from "../redux/slices/cartSlice";

const HeaderCart: React.FC = () => {
    const { totalPrice, items } = useSelector(selectCart);
    // console.log('totalPrice = ' + totalPrice, 'items = ' + items);
    const totalCount = items.reduce(
        (acc: number, item: { count: number }) => acc + item.count,
        0
    );

    return (
        <>
            <div>
                <span>{totalPrice} $</span>
            </div>
            <div>
                <span>
                    <img
                        src=""
                        alt="Иконка корзины"
                    />
                    {totalCount}
                </span>
            </div>
        </>
    );
};

export default HeaderCart;
