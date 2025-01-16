// src/components/Register.js

import React from 'react';

function Register() {
    return (
        <div className="register-container">
            <h2>Register</h2>
            <form>
                <div className="form-group">
                    <label htmlFor="name">Username:</label>
                    <input type="text" id="name" name="name" placeholder="Enter your full name" />
                </div>

                <div className="form-group">
                    <label htmlFor="email">Email:</label>
                    <input type="email" id="email" name="email" placeholder="Enter your email" />
                </div>

                <div className="form-group">
                    <label htmlFor="password">Password:</label>
                    <input type="password" id="password" name="password" placeholder="Enter your password" />
                </div>

                <div className="form-group">
                    <label htmlFor="confirmPassword">Confirm Password:</label>
                    <input type="password" id="confirmPassword" name="confirmPassword" placeholder="Confirm your password" />
                </div>

                <button type="submit">Register</button>
            </form>
        </div>
    );
}

export default Register;
