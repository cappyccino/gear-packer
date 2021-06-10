import React from 'react'
import {render, screen} from '@testing-library/react'
import '@testing-library/jest-dom/extend-expect'

import Header from './Header.jsx'

describe('<Header />', () => {
    beforeEach(() => {
        render(<Header/>)
    })

    it('should display the logo', () => {
        const headerLogo = screen.getByRole(
            "img",
            {label: 'the Gear Packer logo'})

        expect(headerLogo).toBeVisible()
    })

    it('should display the title', () => {
        const headerTitle = screen.getByRole("heading", {level: 1})
        expect(headerTitle).toHaveTextContent('Gear Packer')
    })
})
