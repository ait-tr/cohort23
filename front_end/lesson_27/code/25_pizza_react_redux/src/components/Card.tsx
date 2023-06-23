import React from "react";
import { useSelector } from "react-redux";
import { selectFilter } from "../redux/slices/filterSlice";
import { useDispatch } from "react-redux";
import { addToCart, selectCart, selectCartItemById } from "../redux/slices/cartSlice";
import { selectItemsData, setItem } from "../redux/slices/itemsSlice";

interface CardItem {
    id: string;
    images: string[];
    title: string;
    types: number[];
    sizes: number[];
    price: number;
    rating: number;
    info: string[];
}

const Card: React.FC<CardItem> = ({
    id, title, images, info, price, rating, sizes, types
}) => {
    const counter = useSelector(selectCartItemById(+id));
    const count: number = counter && counter.count;
    const { activeSize, activeType } = useSelector(selectItemsData);
    const { categoryName } = useSelector(selectFilter);
    const isCategory = categoryName === 'Закрытые'
    const dispatch = useDispatch();

    const cardItem: CardItem = {
        id, title, images, info, price, rating, sizes, types
    };

    return (
        <div>
            <div>
                {/* <StarIcon /> */}
                <span>{rating}</span>
            </div>
            <img src={images[0]} alt={title} />
            <h2>
                <a
                    href={`/pizza/${id}`}
                    onClick={() => dispatch(setItem(cardItem))}
                >
                    {title}
                </a>
            </h2>
            <div>
                <span>От {price} $</span>
                 <button onClick={() => {/*dispatch(addToCart(cardItem))}*/}}> 
                    <span>+</span>
                    Добавить
                    { count && <span>{count}</span> }
                </button>
            </div>
        </div>
    );
};

export default Card;
