import { Action } from 'redux';

// описываем интерфейс action (действия) с состоянием внтури приложения
export interface IncrementAction extends Action {
    type: 'INCREMENT';
}

// описываем интерфейс action (действия) с состоянием внтури приложения
export interface DecrementAction extends Action {
    type: 'DECREMENT';
}

export type CounterAction = IncrementAction | DecrementAction;

export const increment = (): IncrementAction => {
    return {
        type: 'INCREMENT'
    }
}

export const decrement = (): DecrementAction => {
    return {
        type: 'DECREMENT'
    }
}