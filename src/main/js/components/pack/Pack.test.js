import React from 'react'
import {render, screen} from '@testing-library/react'
import '@testing-library/jest-dom/extend-expect'

import Pack from './Pack'

describe('<Pack />', () => {
    beforeEach(() => {
        render(<Pack/>)
    })

    describe('when there is no pack', () => {
        it('should display info text', () => {
            screen.getByText("You don't have any packs yet!")
        });
    })
})

