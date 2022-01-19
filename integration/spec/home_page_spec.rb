require 'capybara/dsl'
require 'capybara/rspec'

Capybara.default_driver = :selenium_headless
Capybara.app_host = 'localhost:8080'
Capybara.run_server = false

feature 'the home page' do
  before :each do
    visit '/'
  end

  it 'displays the title bar' do
    expect(page).to have_content 'Gear Packer'
  end

  xit 'allows a user to create a pack with items' do
    expect(page).to have_content "You don't have any packs yet"
    page.find_button('Create').click

    page.fill_in('Pack Name', with: 'The Greatest Pack')
    page.find_button('Add Gear Item').click

    page.fill_in('Gear Name', with: 'My Pack')
    page.fill_in('Gear Weight', with: '500')
    page.find_button('Save').click

    expect(page).to have_content 'My Pack'
    expect(page).to have_content '500 g'

    expect(page).to have_content('Add Gear Item')
  end
end
