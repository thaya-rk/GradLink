import React from 'react';
import { Link } from 'react-router-dom';

const Home = () => {
    return (
        <div>
            <h1>Welcome to GradLink</h1>
            <nav>
                <Link to="/login">Login</Link> | <Link to="/register">Register</Link>
            </nav>
        </div>
    );
};

export default Home;
