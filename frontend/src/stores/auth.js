import { writable } from 'svelte/store';

export const user = writable(null);
export const isAuthenticated = writable(false);

export const setUser = (data) => {
    user.set(data);
    isAuthenticated.set(!!data);
};

export const clearUser = () => {
    user.set(null);
    isAuthenticated.set(false);
};
